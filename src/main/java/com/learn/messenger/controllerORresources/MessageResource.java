package com.learn.messenger.controllerORresources;

import com.learn.messenger.exceptions.MessageNotFoundException;
import com.learn.messenger.model.Message;
import com.learn.messenger.repositoryORservice.MessageRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messenger")
public class MessageResource {

	//Constructor Injection, NO NEED of @AUTOWIRED Annotation
	private MessageRepository messageRepository;
	public MessageResource(MessageRepository messageRepository){
		this.messageRepository = messageRepository;
	}

	// Retrieve all users
	@GetMapping(path = "/all")
	public List<Message> retrieveAllUsers() {
		System.err.println("###################################### Retrieving All messages ######################################");
		return messageRepository.findAll();
	}

	// Retrieve all messages for a specific user
	@GetMapping(path = "/{id}/messages")
	public Message retrieveUserById(@PathVariable("id") @NotBlank Long id) {
		return messageRepository.findById(id)
				.orElseThrow(() -> new MessageNotFoundException("id:" + id));
	}

	// Retrieve all messages for a specific user
	/*@GetMapping(path = "/{author}/messages")
	public Message findAuthorMessages(@PathVariable("author") @NotBlank String author){
		System.err.println("###################################### Retrieving All messages of a user ######################################");
		return messageRepository.retrieveMessagesByAuthor(author)
				.orElseThrow(() -> new MessageNotFoundException(author));
	}*/


	@DeleteMapping("/message/{id}")
	public Message deleteStudent(@PathVariable Long id) {
		Optional<Message> optional = messageRepository.findById(id);

		if(optional.isPresent()){
			messageRepository.deleteById(id);
		}

		return optional.get();
	}

	@PostMapping("/message")
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Message message){
		System.err.println("###################################### POST Begins ######################################");
		Message savedStud = messageRepository.save(message);
		System.err.println("###################################### POST Ends ######################################");
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedStud.getId())
				.toUri();

		return (ResponseEntity<Object>) ResponseEntity.created(location).build();
	}

	@PutMapping("/message/{id}")
	public Message modifyValue(@RequestBody Message newMessage, @PathVariable Long id){
		return messageRepository.findById(id)
				.map(message -> {
					message.setAuthor(newMessage.getAuthor());
					message.setCreated(newMessage.getCreated());
					message.setMessage(newMessage.getMessage());
					return messageRepository.save(message);
				})
				.orElseGet(() -> {
					newMessage.setId(id);
					return messageRepository.save(newMessage);
				});
	}
}
