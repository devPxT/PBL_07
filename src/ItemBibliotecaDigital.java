abstract class ItemBibliotecaDigital {
    private String titulo;
    private String autor;
    private int id;

    public ItemBibliotecaDigital(String titulo, String autor, int id) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getId() {
        return id;
    }


    public abstract String descricao();
}
