class VideoDigital extends ItemBibliotecaDigital implements Baixavel, Visualizavel {
    public VideoDigital(String titulo, String autor, int id) {
        super(titulo, autor, id);
    }

    @Override
    public String descricao() {
        return "Id: " + getId() + " Vídeo: " + getTitulo() + " - Autor: " + getAutor();
    }

    @Override
    public void baixar() {
        System.out.println("Baixando o vídeo: " + getTitulo());
        System.out.println("-----------------------------100%");
        System.out.println("Vídeo baixado: " + getTitulo());
    }

    @Override
    public void visualizar() {
        this.baixar();
        System.out.println("Visualizando o vídeo: " + getTitulo());
    }
}