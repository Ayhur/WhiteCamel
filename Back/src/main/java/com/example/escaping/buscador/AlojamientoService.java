package com.example.escaping.buscador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.escaping.data.model.Hotel;

@Service
public class AlojamientoService {

	@Autowired
	private LocalidadRepository localidadRepository;
	@Autowired
	private ProvinciaRepository provinciaRepository;

	public List<Hotel> buscarPorLocalidadOProvincia(BusquedaDTO busquedaDTO) {
		List<Hotel> resultados = new ArrayList<>();
		
		BusquedaDTO busquedaLoc = new BusquedaDTO();
		
		if (busquedaDTO.getCiudad() != null) {
			// Buscar "hoteles" por localidad
			busquedaLoc =  localidadRepository.findAlojamientosByLocalidad(busquedaDTO.getCiudad());
		}
		
		if(null != busquedaLoc) {
			return localidadRepository.findAlojamientosByLocalidad(busquedaLoc.getId_localidades());
		}
//		else if (busquedaDTO.getId_provincia() != null) {
//			// Buscar "hoteles" por provincia
//			// resultados.addAll(provinciaRepository.findAlojamientosByProvinciaId(busquedaDTO.getProvinciaId()));
//		}

		return resultados;
	}
}



/*  
@Service
public class AlojamientoService {

    @Autowired
    private HotelRepository hotelRepository; // Asume que tienes un repositorio para Hotel

    public List<AlojamientoDTO> buscarPorLocalidadOProvincia(BusquedaDTO busquedaDTO) {
        List<AlojamientoDTO> resultados = new ArrayList<>();
        if (busquedaDTO.getIdLocalidad() != null) {
            // Implementa la búsqueda en HotelRepository por localidad
            List<Hotel> hoteles = hotelRepository.findByLocalidadId(busquedaDTO.getIdLocalidad());
            for (Hotel hotel : hoteles) {
                resultados.add(new AlojamientoDTO(hotel.getNombre(), hotel.getDireccion(), hotel.getTelefono()));
            }
        } else if (busquedaDTO.getIdProvincia() != null) {
            // Implementa la búsqueda en HotelRepository por provincia
            // Asumiendo que tienes la lógica para esto, posiblemente necesites unir tablas entre localidades y provincias
        }
        return resultados;
    }
}

 */
