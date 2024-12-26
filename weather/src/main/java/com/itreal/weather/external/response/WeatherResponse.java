package com.itreal.weather.external.response;

import java.util.Date;
import lombok.Data;

@Data
public class WeatherResponse {
	private Coord coord;
	private Weather[] weather;
	private String base;
    private Main main;
    private long visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private Date dt;
    private Sys sys;
    private long timezone;
    private long id;
    private String name;
    private int cod;
    
    @Data
    public static class Coord {
    	private double lon;
     	private double lat;
    }   
    @Data
    public static class Weather {
    	private long id;
    	private String main;
     	private String description;
     	private String icon;
    }
	@Data
	public static class Main {
	    private double temp;
	    private double feels_like;
	    private double temp_min;
	    private double temp_max;
	    private int pressure;
	    private int humidity;
	    private int sea_level;
	    private int grnd_level;
	}
    @Data
    public static class Wind {
        private double speed;
        private int deg;
    }
    @Data
    public static class Rain {
        private double oneh;
    }
    @Data
    public static class Clouds {
        private int all;
    }
    @Data
    public static class Sys {
        private int type;
        private long id;
        private String country;
        private long sunrise;
        private long sunset;
    }
}
