package by.slivki.trainings.rest.api;

import by.slivki.trainings.rest.dto.StatusDto;
import by.slivki.trainings.rest.dto.TrainerApplicationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface ApplicationController {

    /**
     * Processes GET request to '/applications'.
     * Loads all applications.
     *
     * @return list of applications
     * */
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAll();

    /**
     * Processes GET request to '/applications/{id}'.
     * Gets application by id.
     *
     * @param id application id
     *
     * @return application dto
     * */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<?> getApplication (@PathVariable int id);

    /**
     * Processes POST request to '/applications/{id}'.
     * Modifies status of application by id and statusDto.
     *
     * @param id application id
     * @param statusDto new status of application
     *
     * @return result (true or false)
     * */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    ResponseEntity<?> updateApplication (
            @PathVariable int id,
            @RequestBody @Valid StatusDto statusDto
    );

    /**
     * Processes POST request to '/applications/{id}'.
     * Deletes application by id.
     *
     * @param id application id
     *
     * @return result (true or false)
     * */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteApplication(@PathVariable int id);

    /**
     * Processes POST request to '/applications/password'.
     * If user with the mail existed then it changes it and
     * receives a message to user mail.
     *
     * @param mail mail
     *
     * @return result (true or false)
     * */
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    ResponseEntity<?> createApplicationOnPassword(@RequestParam String mail);

    /**
     * Processes POST request to '/applications/password'.
     * If user with the mail existed then it changes it and
     * receives a message to user mail.
     *
     * @param applicationDto application with login, mail and message
     *
     * @return result (true or false)
     * */
    @RequestMapping(value = "/trainer", method = RequestMethod.POST)
    ResponseEntity<?> createApplicationOnTrainer(
            @RequestBody @Valid TrainerApplicationDto applicationDto);
}
