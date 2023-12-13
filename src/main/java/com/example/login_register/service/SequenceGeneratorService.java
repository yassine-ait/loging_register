package com.example.login_register.service;

import com.example.login_register.entities.DbSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {
    private final MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public int getSequenceNumber(String sequenceName) {
        // create a query
        Query query = Query.query(Criteria.where("id").is(sequenceName));

        // update the sequence number
        Update update = new Update().inc("seq", 1);

        // find and modify the document
        DbSequence counter = mongoOperations.findAndModify(
                query,
                update,
                options().returnNew(true).upsert(true),
                DbSequence.class
        );

        return (counter != null) ? counter.getSeq() : 1;
    }
}
