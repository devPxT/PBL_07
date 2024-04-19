class VideoDigital extends ItemBibliotecaDigital implements Baixavel, Visualizavel {
    public VideoDigital(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public String descricao() {
        return "Vídeo: " + getTitulo() + " - Autor: " + getAutor();
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