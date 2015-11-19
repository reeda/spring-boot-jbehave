package com.github.reeda.springbootjbehave;

import org.springframework.stereotype.Service;

/**
 * Created by andrew on 11/18/15.
 */
@Service
public class ApplicationService {

    public int multiply(int x, int y) {
        return x * y;
    }

}
