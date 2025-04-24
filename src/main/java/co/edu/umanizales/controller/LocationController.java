package co.edu.umanizales.controller;

import co.edu.umanizales.model.Location;
import co.edu.umanizales.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getLocations();

    }
    //esta ruta es para buscar los elementos por codigo.
    @GetMapping(path = "/{code}")
    public Location getLocationByCode(@PathVariable String code){
        return locationService.getLocationByCode(code);

    }
    //esta ruta es para buscar los municipios por nombre.
    @GetMapping(path = "/city/{name}")
    public List<Location> getLocationsByName(@PathVariable String name){
        return locationService.getName(name);
    }

    //esta ruta es para buscar los municipios por la letra inicial.
    @GetMapping("/municipios/inicial/{letra}")
    public List<Location> getLocationsByInitial(@PathVariable String letra) {
        return locationService.getLocationsByInitial(letra);
    }

    //esta ruta es para buscar los departamentos por nombre.
    @GetMapping(path = "/state/{nombre}")
    public List<Location> getLocationsByStates(@PathVariable String nombre){
        return locationService.getStates(nombre);
    }

    //esta ruta es para buscar los departamentos por codigo.
    @GetMapping(path = "/state/code/{code}")
    public List<Location> getLocationsStatesByCode(@PathVariable String code){
        return locationService.getStatesByCode(code);
    }
    //esta es la ruta para buscar las capitales .
    @GetMapping("/capitales")
    public List<Location> getCapitales() {
        return locationService.getCapitales();
    }

    // Ruta para obtener localidades cuyo nombre del municipio tenga una longitud mayor a 'length'
    @GetMapping("/largo")
    public List<Location> getLocationsByNameLength(@RequestParam int length) {
        return locationService.getLocationsByNameLength(length);
    }

}


