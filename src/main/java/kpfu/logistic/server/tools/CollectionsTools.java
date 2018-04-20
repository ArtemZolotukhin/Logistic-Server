/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kpfu.logistic.server.tools;

import java.util.Collection;

/**
 *
 * @author rz
 */
public class CollectionsTools {
    
    public static <T> boolean containAll(Collection<T> tCollection, T ... t) {
        
        if (t == null) {
            return true;
        }
        
        if (t.length == 0) {
            return true;
        }
        
        if (tCollection == null) {
            return false;
        }
        
        if (tCollection.isEmpty()) {
            return false;
        }
        
        
        boolean isContainI = false;
        
        for (int i = 0; i < t.length; i++) {
            
            isContainI = false;
            
            for(T j : tCollection) {
                if (t[i] == null) {
                    if (j == null) {
                        isContainI = true;
                        break;
                    }
                } else { 
                    if (t[i].equals(j)) {
                        isContainI = true;
                        break;
                    }
                }
            }
            
            if (!isContainI) {
                return false;
            }
            
        }
        
        return true;
    }
    
}
