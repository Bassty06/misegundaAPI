
package co.edu.umanizales.service;

import co.edu.umanizales.model.Location;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Getter
public class LocationService {

    private final List<Location> locations = new ArrayList<>();

    @PostConstruct
    public void loadLocationsFromCSV() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(getClass().getResourceAsStream("/divipola.csv")),
                        StandardCharsets.UTF_8))) {

            String linea;
            boolean primera = true;

            while ((linea = br.readLine()) != null) {
                if (primera) {
                    primera = false;
                    continue;
                }

                String[] partes = linea.split(",", -1);
                if (partes.length >= 4) {
                    locations.add(new Location(
                            partes[0].trim(),
                            partes[1].trim(),
                            partes[2].trim(),
                            partes[3].trim()
                    ));
                }
            }

            System.out.println("Se cargaron " + locations.size() + " registros de Location.");

        } catch (Exception e) {
            System.err.println("Error al cargar el archivo CSV:");
            e.printStackTrace(); // ¡Esto es útil para depurar!
        }
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Location getLocationByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getName(String nombreMunicipio) {
        List<Location> states = new ArrayList<>();
        for (Location location : locations) {
            if (location.getNombreMunicipio().equalsIgnoreCase(nombreMunicipio)) {
                states.add(location);
            }
        }
        return states;
    }

    public List<Location> getLocationsByInitial(String letra) {
        List<Location> states = new ArrayList<>();
        for (Location location : locations) {
            if (location.getNombreMunicipio().toLowerCase().startsWith(letra.toLowerCase())) {
                states.add(location);
            }
        }
        return states;
    }

    public List<Location> getStates(String nombreDepartamento) {
        List<Location> states = new ArrayList<>();
        for (Location location : locations) {
            if (location.getNombreDepartamento().equalsIgnoreCase(nombreDepartamento)) {
                states.add(location);
            }
        }
        return states;
    }

    public List<Location> getStatesByCode(String codigoDepartamento) {
        List<Location> states = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCodigoDepartamento().equals(codigoDepartamento)) {
                states.add(location);
            }
        }
        return states;
    }

    public List<Location> getCapitales() {
        List<Location> capitales = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCode().length() == 5 && location.getCode().endsWith("01")) {
                capitales.add(location);
            }
        }
        return capitales;
    }

}




