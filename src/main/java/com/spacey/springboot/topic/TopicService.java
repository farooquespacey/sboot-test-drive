package com.spacey.springboot.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
//	private List<Topic> topics = new ArrayList<>(
//			Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
//					new Topic("java", "Core Java", "Java Description"),
//					new Topic("javascript", "JavaScript", "JavaScript Description")));

	public List<Topic> getAllTopics() {
//		return topics;
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
//		topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
//		for (int i = 0; i < topics.size(); i++) {
//			if (topics.get(i).getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		addTopic(topic);
	}

	public void deleteTopic(String id) {
//		topics.removeIf(t -> t.getId().equals(id));
		topicRepository.delete(id);
	}

}
