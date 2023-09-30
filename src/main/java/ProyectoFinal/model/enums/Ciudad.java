package ProyectoFinal.model.enums;

public enum Ciudad {
    ARMENIA("ARMENIA"),
    CALARCA("CALARCA"),
    CIRCASIA("CIRCASIA"),
    CORDOBA("CORDOBA"),
    FILANDIA("FILANDIA"),
    GENOVA("GENOVA"),
    TEBAIDA("TEBAIDA"),
    MONTENEGRO("MONTENEGRO"),
    PIJAO("PIJAO"),
    QUIMBAYA("QUIMBAYA"),
    SALENTO("SALENTO"),
    BOGOTA("BOGOTA"),
    MEDELLIN("MEDELLIN"),
    CALI("CALI"),
    BARRANQUILLA("BARRANQUILLA"),
    CARTAGENA("CARTAGENA"),
    SANTA_MARTA("SANTA MARTA"),
    BUCARAMANGA("BUCARAMANGA"),
    PEREIRA("PEREIRA"),
    MANIZALES("MANIZALES");

    private String nombre;
    Ciudad(String nombre) {
        this.nombre = nombre;
    }

}
