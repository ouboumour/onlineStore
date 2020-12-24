/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.core;

import com.directmedia.onlinestore.core.entity.*;
import java.util.HashSet;

/**
 *
 * @author oussa
 */
public class Startup {
    
    public static void main(String[] args) {
        Work work1 = new Work("work1");
        Work work2 = new Work("work2");
        Work work3 = new Work("work3");
    
        work1.setGenre("Sad");
        work1.setMainArtist(new Artist("artist 1"));
        work1.setRelease(1990);
        work1.setSummary("summary 1");
            
        work2.setGenre("Happy");
        work2.setMainArtist(new Artist("artist 2"));
        work2.setRelease(1999);
        work2.setSummary("summary 2");
            
        work3.setGenre("2018");
        work3.setMainArtist(new Artist("artist 3"));
        work3.setRelease(2016);
        work3.setSummary("summary 3");
        
        HashSet<Work> works = new HashSet<Work>();
        
        works.add(work1);;
        works.add(work2);
        works.add(work3);

        Catalogue.listeOfWorks = works;
                  

        for (Work h : Catalogue.listeOfWorks) {
            System.out.println(h.getTitle()+"("+h.getRelease()+")");
        }
    }
    
}
