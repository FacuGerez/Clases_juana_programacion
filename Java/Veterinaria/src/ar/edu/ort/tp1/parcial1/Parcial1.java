package ar.edu.ort.tp1.parcial1;

import ar.edu.ort.tp1.parcial1.clases.*;

public class Parcial1 {

    public static void main(String[] args) {
        Veterinaria clinicaVeterinaria = new Veterinaria("Cuidamos tu mascota", new Doctor("Veterinovich"));
        System.out.println("Admitiendo Mascotas----");
        clinicaVeterinaria.admitirMascota(new Perro("Guardian", 230, false, Estado.ENFERMO));
        clinicaVeterinaria.admitirMascota(new Gato("Isa", 230, false, Estado.FELIZ));
        clinicaVeterinaria.admitirMascota(new Conejo("Fox", 230, true, Estado.HAMBRIENTO));
        clinicaVeterinaria.admitirMascota(new Conejo("Eric", 230, false, Estado.FELIZ));
        clinicaVeterinaria.admitirMascota(new Perro("Beethoven", 230, false, Estado.ENFERMO));
        clinicaVeterinaria.admitirMascota(new Perro("Hachiko", 230, true, Estado.HAMBRIENTO));
        clinicaVeterinaria.admitirMascota(new Gato("Flipper", 230, false, Estado.ENFERMO));
        clinicaVeterinaria.admitirMascota(new Gato("Garras", 230, false, Estado.ENFERMO));
        System.out.println();
        System.out.println("Asistiendo Mascotas----");
        Animal mascota = clinicaVeterinaria.buscarMascota("Hachiko");
        mascota.comer(10);
        mascota.defecar();
        
        mascota = clinicaVeterinaria.buscarMascota("Guardian");
        mascota.comer(5);
        mascota.defecar();
        
        mascota = clinicaVeterinaria.buscarMascota("Eric");
        mascota.comer(55);
        mascota.defecar();
        
        
        System.out.println();
        System.out.println("Vacunando Mascotas----");
        clinicaVeterinaria.vacunar();
        System.out.println();
        System.out.println("----");
        clinicaVeterinaria.mostrar();
    }
}
