import entity.Gato;
import entity.GatoFav;
import service.GatoService;
import service.impl.GatoServiceImpl;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        GatoService gatoService = new GatoServiceImpl();

        Gato gato = gatoService.getRandomGato();

        System.out.println(gato.getId());
        System.out.println(gato.getUrl());
        System.out.println(gato.getImage());

        gatoService.addToFavorites(gato.getId());

        System.out.println("-----------gatos fav-----------");
        List<GatoFav> gatosFavs = gatoService.getFavGatos();

        for ( GatoFav gatoFav : gatosFavs ) {
            System.out.println("id: " + gatoFav.getId());
            System.out.println("gato image id: " + gatoFav.getImage().getId());
            System.out.println("image url: " + gatoFav.getImage().getUrl());
        }

        System.out.println("-------------eliminar gato fav----------------");

        boolean success = gatoService.deleteFavGato("2105207");

        System.out.println(success);

        System.out.println("------------gato fav selected-----------------");

        GatoFav gatoFav = gatoService.getGatoFavById("2105212");

        System.out.println("id: " + gatoFav.getId());
        System.out.println("id image: " + gatoFav.getImage().getId());
        System.out.println("url image: " + gatoFav.getImage().getUrl());
    }

}
