import data.Processing;
import java.io.File;
import java.io.IOException;
import templates.Persona;
import org.apache.commons.io.input.ReversedLinesFileReader;
import java.lang.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

    ArrayList<Persona> personas = new ArrayList<>();
    ArrayList<Persona> outPersonas = new ArrayList<>();

        personas.add(new Persona(
                1,
                "Pedro Rodirguez",
                24,
                1.70,
                75
        ));
        personas.add(new Persona(
                2,
                "Juan Perez",
                44,
                1.60,
                80
        ));
        personas.add(new Persona(
                3,
                "Jose Jimenez",
                32,
                1.80,
                67
        ));

        Processing processing = new Processing();
        processing.guardarPersonasEnArchivo(personas, "personas.txt");
        outPersonas = processing.leerPersonasDeArchivo("personas.txt");
        for (int i=0; i< outPersonas.size(); i++){
            System.out.println(
                    outPersonas.get(i).getId() + " | " +
                    outPersonas.get(i).getNombre() + " | " +
                            outPersonas.get(i).getEdad() + " | " +
                            outPersonas.get(i).getEstatura() + " | " +
                            outPersonas.get(i).getPeso() + " | "
            );
        }
        
        File file = new File("personas.txt");
        ReversedLinesFileReader object = new ReversedLinesFileReader(file);
        String line = object.readLine();
        System.out.println(line);
        String pattern = "\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)";
        Matcher matcher = Pattern.compile(pattern).matcher(line);
        Persona personaUltima = null;
        if (matcher.find()) {
            personaUltima = new Persona(
                                Long.parseLong(matcher.group(1)),
                                matcher.group(2),
                                Integer.parseInt( matcher.group(3) ),
                                Double.parseDouble( matcher.group(4) ),
                                Integer.parseInt( matcher.group(5) )
                        );
        }
        System.out.println(personaUltima.toString());
        long ultimoid = personaUltima.getId();
        personas.add(new Persona(
                ultimoid+1,
                "Yiiii",
                27,
                1.50,
                80
        ));
        personas.add(new Persona(
                ultimoid+2,
                "minecrah",
                27,
                1.50,
                80
        ));
        processing.guardarPersonasEnArchivo(personas, "personas.txt");
        outPersonas = processing.leerPersonasDeArchivo("personas.txt");
        for (int i=0; i< outPersonas.size(); i++){
            System.out.println(
                    outPersonas.get(i).getId() + " | " +
                    outPersonas.get(i).getNombre() + " | " +
                            outPersonas.get(i).getEdad() + " | " +
                            outPersonas.get(i).getEstatura() + " | " +
                            outPersonas.get(i).getPeso() + " | "
            );
        }
        

    }
}
