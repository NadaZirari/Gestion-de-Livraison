package mapper;

import com.delivrey.dto.TourDTO;
import com.delivrey.dto.DeliveryDTO;
import com.delivrey.entity.Tour;

import java.util.stream.Collectors;

public class TourMapper {

    public static TourDTO toDto(Tour tour) {
        if (tour == null) return null;
        TourDTO dto = new TourDTO();
        dto.setId(tour.getId());
        dto.setDate(tour.getTourDate());
        dto.setVehicleId(tour.getVehicle() != null ? tour.getVehicle().getId() : null);
        dto.setWarehouseId(tour.getWarehouse() != null ? tour.getWarehouse().getId() : null);
        dto.setStatus(tour.getAlgorithmUsed()); // <- ici, status = algorithmUsed
        dto.setDeliveries(tour.getDeliveries() != null
                ? tour.getDeliveries().stream().map(DeliveryMapper::toDto).collect(Collectors.toList())
                : null);
        return dto;
    }

    public static Tour toEntity(TourDTO dto) {
        if (dto == null) return null;
        Tour tour = new Tour();
        tour.setTourDate(dto.getDate());
        tour.setAlgorithmUsed(dto.getStatus()); // <- status du DTO -> algorithmUsed de Tour
        return tour;
    }

    public static void updateEntity(Tour tour, TourDTO dto) {
        if (tour == null || dto == null) return;
        tour.setTourDate(dto.getDate());
        tour.setAlgorithmUsed(dto.getStatus()); // <- correction ici
        // Livraison, véhicule, warehouse à gérer via le service si nécessaire
    }
}
