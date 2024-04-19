class Ebook extends ItemBibliotecaDigital implements Baixavel {
    public Ebook(String titulo, String autor, int id) {
        super(titulo, autor, id);
    }

    @Override
    public String descricao() {
        return  "[Id. " + getId() + "] Ebook: " + getTitulo() + " - Autor: " + getAutor();
    }

    @Override
    public void baixar() {
        System.out.println("Baixando o ebook: " + getTitulo());
        System.out.println("-----------------------------100%");
        System.out.println("Ebook baixado: " + getTitulo());
    }
}