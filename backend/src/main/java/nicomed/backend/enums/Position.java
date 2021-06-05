package nicomed.backend.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public enum Position {
    ENG(0,"Инженер",Set.of(Permission.DEVELOPERS_READ)),
    MN_BURO(1,"Начальник бюро",Set.of(Permission.DEVELOPERS_READ)),
    NK(2,"Нормоконтролер",Set.of(Permission.DEVELOPERS_READ)),
    MN_NK(3,"Начальник ОРиТП",Set.of(Permission.DEVELOPERS_READ)),
    ECON(4,"Экономист",Set.of(Permission.DEVELOPERS_READ)),
    ZMN(5,"Зам. начальника управления",Set.of(Permission.DEVELOPERS_READ)),
    MN(6,"Начальник управления",Set.of(Permission.DEVELOPERS_READ)),
    ADMIN(7,"Администратор",Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE));

    private final String name;
    private final int id;
    private final Set<Permission> permissions;

    Position(int id,String name, Set<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public static List<String> getNamesAsString(){
        return Arrays.asList(Position.values()).stream()
                .map(p -> p.getName())
                .collect(Collectors.toList());
    }

    public static Map<Position,String> getPositionAsMap(){
        return Arrays.asList(Position.values()).stream()
                .collect(Collectors.toMap(p -> p,p -> p.getName()));
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }


}
