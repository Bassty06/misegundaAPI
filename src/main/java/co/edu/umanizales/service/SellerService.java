package co.edu.umanizales.service;

import co.edu.umanizales.model.Seller;
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
public class SellerService {

    private final List<Seller> sellers = new ArrayList<>();

    @PostConstruct
    public void loadSellersFromCSV() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream("/sellers.csv")),
                StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";", -1);
                if (parts.length >= 6) {
                    sellers.add(new Seller(
                            parts[0].trim(),
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim(),
                            Integer.parseInt(parts[4].trim()),
                            parts[5].trim()
                    ));
                }
            }

            System.out.println("Se cargaron " + sellers.size() + " registros de Seller.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Seller> listarTodos() {
        return sellers;
    }
}


