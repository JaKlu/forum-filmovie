package com.kuba.forum.database.memory;

import com.kuba.forum.database.ITopicDAO;
import com.kuba.forum.database.sequences.ITopicSequence;
import com.kuba.forum.model.Thread;
import com.kuba.forum.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TopicDAO implements ITopicDAO {
    @Autowired
    ITopicSequence topicSequence;
    private final List<Topic> topics = new ArrayList<>();

    public TopicDAO(ITopicSequence topicSequence) {
        this.topicSequence = topicSequence;

        topics.add(new Topic(topicSequence.getId(), "Powitania", "Tutaj możesz sie przywitać i napisać o sobie kilka słów!"));
        topics.add(new Topic(topicSequence.getId(), "Filmy polskie", "Rozmowy o filmach nakręconych w Polsce"));
        topics.add(new Topic(topicSequence.getId(), "Filmy zagraniczne", "Rozmowy o filmach nakręconych za granicą"));
        topics.add(new Topic(topicSequence.getId(), "Seriale polskie", "Rozmowy o serialach nakręconych w Polsce"));
        topics.add(new Topic(topicSequence.getId(), "Seriale zagraniczne", "Rozmowy o serialach nakręconych za granicą"));
        topics.add(new Topic(topicSequence.getId(), "Reżyserzy polscy", "Rozmowy o reżyserach pochodzących z Polski"));
        topics.add(new Topic(topicSequence.getId(), "Reżyserzy zagraniczni", "Rozmowy o reżyserach pochodzących zza granicy"));
        topics.add(new Topic(topicSequence.getId(), "Kino", "Rozmowy o premierach i aktualnie wyświetlanych filmach na wielkim ekranie"));
        topics.add(new Topic(topicSequence.getId(), "Streaming", "Rozmowy o premierach i aktualnie wyświetlanych filmach na małym ekranie"));
        topics.add(new Topic(topicSequence.getId(), "Off Topic", "Rozmowy o wszystkim i o niczym"));
    }

    public List<Topic> getAllTopics() {
        return new ArrayList<>(this.topics);
    }

    @Override
    public Topic findTopicById(int topicId) {
        for (Topic topic : this.topics) {
            if (topic.getId() == (topicId)) {
                return topic;
            }
        }
        return null;
    }

    public void addTopic(Topic topic) {
        topic.setId(topicSequence.getId());
        this.topics.add(topic);
    }
}