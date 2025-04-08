
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
    public List<Location> loadLocationsFromCSV() {
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
        }
        {
            {
                   return locations;
        }
        }
    }
}




