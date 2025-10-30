package mapper;


import com.delivrey.dto.DeliveryDTO;
import com.delivrey.entity.Delivery;

public class DeliveryMapper {

    public static DeliveryDTO toDto(Delivery e) {
        if (e == null) return null;
        DeliveryDTO dto = new DeliveryDTO();
        dto.setId(e.getId());
        dto.setAddress(e.getAddress());
        dto.setLatitude(e.getLatitude());
        dto.setLongitude(e.getLongitude());
        dto.setWeight(e.getWeight());
        dto.setVolume(e.getVolume());
        dto.setTimeWindow(e.getTimeWindow());
        dto.setStatus(e.getStatus() != null ? e.getStatus().name() : null);
        return dto;
    }

    public static Delivery toEntity(DeliveryDTO d) {
        if (d == null) return null;
        Delivery e = new Delivery();
        e.setId(d.getId());
        e.setAddress(d.getAddress());
        e.setLatitude(d.getLatitude());
        e.setLongitude(d.getLongitude());
        e.setWeight(d.getWeight());
        e.setVolume(d.getVolume());
        e.setTimeWindow(d.getTimeWindow());
        // status handled by service if needed
        return e;
    }
}
