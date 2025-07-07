package life.hebo.maker.model;

import lombok.Data;

/**
 * defines the configuration for the template. Used for dynamic generation.
 * @author BO HE
 */

@Data
public class DataModel {

    // Our requirements for dynamic generation:
    // 1. Add an author @Author comment at the beginning of the code (add code)
    // 2. Modify the program’s output information prompt (replace code)
    // 3. Change the loop input reading to single-time reading (optional code)

    private String author = "BB";
    private String outputMessage = "Sum: ";
    private boolean loop = false;
}
