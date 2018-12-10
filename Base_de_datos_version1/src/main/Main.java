
package main;

import view.Views;
import model.Models;
import controller.Controllers;

public class Main {
    
    
    public static void main(String[] args) {
        Models modelBD = new Models();
        Views viewBD = new Views();
        Controllers controllerBD = new Controllers(modelBD, viewBD);
    }
}