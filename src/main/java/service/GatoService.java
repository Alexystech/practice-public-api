package service;

import entity.Gato;
import entity.GatoFav;

import java.util.List;

public interface GatoService {
    List<GatoFav> getFavGatos();
    Gato getRandomGato();
    void addToFavorites(String id_gato);
    boolean deleteFavGato(String id_gato_fav);
    GatoFav getGatoFavById(String id_gato_fav);
}
