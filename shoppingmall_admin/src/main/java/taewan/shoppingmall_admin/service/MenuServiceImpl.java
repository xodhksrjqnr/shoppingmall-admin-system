package taewan.shoppingmall_admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.dto.menu.CategoryDto;
import taewan.shoppingmall_admin.dto.menu.RequestMenuAddDto;
import taewan.shoppingmall_admin.dto.menu.RequestMenuModifyDto;
import taewan.shoppingmall_admin.dto.menu.RequestMenuRemoveDto;
import taewan.shoppingmall_admin.entity.Menu;
import taewan.shoppingmall_admin.repository.menu.MenuRepository;
import taewan.shoppingmall_admin.util.Convertor;

import java.security.InvalidParameterException;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public CategoryDto searchAll() {
        Map<Integer, CategoryDto> menus = new LinkedHashMap<>();

        menuRepository.findAll()
                .forEach(menu -> {
                    CategoryDto category = menus.getOrDefault(menu.getId(), Convertor.toCategoryDto(menu));
                    int parentCategoryId = menu.getParentMenuId();

                    if (!menus.containsKey(parentCategoryId))
                        menus.put(parentCategoryId, new CategoryDto());

                    menus.get(parentCategoryId).addSubCategoryDto(category);
                });

        return menus.get(0);
    }

    @Override
    public void add(RequestMenuAddDto dto) {
        int parentAccessLevel = menuRepository.findById(dto.getParentMenuId())
                .orElseThrow(InvalidParameterException::new)
                .getAccessLevel();

        Menu menu = Menu.create(dto, parentAccessLevel);

        this.menuRepository.save(menu);
    }

    @Override
    public void modify(RequestMenuModifyDto dto) {
        Menu menu = menuRepository.findById(dto.getId())
                .orElseThrow(InvalidParameterException::new);

        int parentAccessLevel = menuRepository.findById(menu.getParentMenuId()).get().getAccessLevel();

        menu.update(dto, parentAccessLevel);
    }

    @Override
    public void delete(RequestMenuRemoveDto dto) {
        menuRepository.deleteById(dto.getId());
    }
}
