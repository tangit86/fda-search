package com.than.fdasearch.fdaclient.model;

import java.util.List;

public class Results {
    public int skip;
    public int limit;
    public int total;
    public List<Submission> submissions;
    public String application_number;
    public String sponsor_name;
    public Openfda openfda;
    public List<Product> products;
}
