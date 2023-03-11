package org.example.bookcase.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.bookcase.model.Book;
import org.example.bookcase.model.Writer;
import org.example.bookcase.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;

    Logger logger = LogManager.getLogger(WriterService.class);

    @Transactional(readOnly = false)
    public Writer saveWriter(Writer writer) throws Exception {
        if (writer == null) {
            throw new Exception("Entity not found");
        }
        return writerRepository.save(writer);
    }

    public List<Writer> fetchWriterList()
    {
        logger.info("INFO Getting writers from database");

        List<Writer> writers =
                writerRepository.findAll();
        logger.info(writers);
        return writers;
    }
}
