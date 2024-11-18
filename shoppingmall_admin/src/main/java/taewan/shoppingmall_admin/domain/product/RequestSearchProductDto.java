package taewan.shoppingmall_admin.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestSearchProductDto {

    String name;
    String code;
    String[] brand;

    public String makeWhere() {
        StringBuilder where = new StringBuilder();

        if (name != null)
            where.append(" (name like '%").append(name).append("%'")
                    .append(" or nameEng like '%").append(name).append("%')").append(" and");
        if (code != null)
            where.append(" code like '%").append(code).append("%'").append(" and");
        if (brand != null && brand.length > 0) {
            where.append(" brand in (");
            for (String b : brand) {
                where.append("'").append(b).append("'").append(",");
            }
            where.deleteCharAt(where.length() - 1).append(")").append(" and");
        }
        if (where.length() > 0) {
            where.delete(where.length() - 3, where.length());
            where.insert(0, " where");
        }
        return where.toString();
    }

}
