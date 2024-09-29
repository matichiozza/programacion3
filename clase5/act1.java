import java.util.*;

class Usuario {
    private String id;

    public Usuario(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class RedSocial {
    private Map<Usuario, List<Usuario>> seguidores;

    public RedSocial() {
        seguidores = new HashMap<>();
    }

    // Agregar un nuevo usuario
    public void agregarUsuario(Usuario usuario) {
        if (!seguidores.containsKey(usuario)) {
            seguidores.put(usuario, new ArrayList<>());
        }
    }

    // Permitir que un usuario siga a otro
    public void seguir(Usuario seguidor, Usuario seguido) {
        if (seguidores.containsKey(seguidor) && seguidores.containsKey(seguido)) {
            List<Usuario> seguidos = seguidores.get(seguidor);
            if (!seguidos.contains(seguido)) {
                seguidos.add(seguido);
            }
        } else {
            System.out.println("Uno o ambos usuarios no existen en el sistema.");
        }
    }

    // Permitir que un usuario deje de seguir a otro
    public void dejarDeSeguir(Usuario seguidor, Usuario seguido) {
        if (seguidores.containsKey(seguidor)) {
            List<Usuario> seguidos = seguidores.get(seguidor);
            if (seguido != null && seguidos.contains(seguido)) {
                seguidos.remove(seguido);
            }
        }
    }

    // Consultar la lista de usuarios que sigue un usuario dado
    public List<Usuario> listaDeSeguidos(Usuario usuario) {
        return seguidores.getOrDefault(usuario, new ArrayList<>());
    }

    // Consultar la lista de usuarios que siguen a un usuario dado
    public List<Usuario> listaDeSeguidores(Usuario usuario) {
        List<Usuario> seguidoresUsuarios = new ArrayList<>();
        for (Map.Entry<Usuario, List<Usuario>> entry : seguidores.entrySet()) {
            if (entry.getValue().contains(usuario)) {
                seguidoresUsuarios.add(entry.getKey());
            }
        }
        return seguidoresUsuarios;
    }

    public static void main(String[] args) {
        // Crear usuarios
        Usuario alice = new Usuario("Alice");
        Usuario bob = new Usuario("Bob");
        Usuario carol = new Usuario("Carol");

        // Crear red social
        RedSocial redSocial = new RedSocial();

        // Agregar usuarios
        redSocial.agregarUsuario(alice);
        redSocial.agregarUsuario(bob);
        redSocial.agregarUsuario(carol);

        // Alice sigue a Bob y Carol
        redSocial.seguir(alice, bob);
        redSocial.seguir(alice, carol);

        // Bob sigue a Carol
        redSocial.seguir(bob, carol);

        // Imprimir la lista de usuarios que sigue Alice
        System.out.println("Usuarios que sigue Alice: " + redSocial.listaDeSeguidos(alice));

        // Imprimir la lista de seguidores de Carol
        System.out.println("Usuarios que siguen a Carol: " + redSocial.listaDeSeguidores(carol));

        // Alice deja de seguir a Bob
        redSocial.dejarDeSeguir(alice, bob);

        // Imprimir la lista de usuarios que sigue Alice después de dejar de seguir a Bob
        System.out.println("Usuarios que sigue Alice después de dejar de seguir a Bob: " + redSocial.listaDeSeguidos(alice));
    }
}
