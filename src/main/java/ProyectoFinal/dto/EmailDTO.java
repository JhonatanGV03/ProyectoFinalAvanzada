package ProyectoFinal.dto;

public record EmailDTO(
        String mensaje,
        String destinatario,
        String asunto,
        String remitente
) {
}
