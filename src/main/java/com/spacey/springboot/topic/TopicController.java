package com.spacey.springboot.topic;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spacey.springboot.exception.TopicNotFoundException;

@RestController
public class TopicController {

	// REF: https://www.javatpoint.com/restful-web-services-internationalization
	// autowires from the AppClient.java's version
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Resource<Topic> getTopic(@PathVariable("id") String id) {
		Topic topic = topicService.getTopic(id);
		if (topic == null) {
			String notFoundMsg = messageSource.getMessage("not.found.message", null, LocaleContextHolder.getLocale());
			// REF: https://www.javatpoint.com/restful-web-services-exception-handling
			throw new TopicNotFoundException("Id: " + id + " " + notFoundMsg);
		}
		// REF: https://www.javatpoint.com/restful-web-services-hateoas
		// "all-topics", SERVER_PATH + "/topics"
		// retrieveAllUsers
		Resource<Topic> resource = new Resource<Topic>(topic); // constructor of Resource class
		// add link to retrieve all the users
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllTopics());
		resource.add(linkTo.withRel("all-topics"));
		return resource;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}
