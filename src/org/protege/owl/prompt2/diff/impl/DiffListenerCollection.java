package org.protege.owl.prompt2.diff.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import org.protege.owl.prompt2.diff.DiffListener;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLEntity;

public class DiffListenerCollection {
    private Collection<DiffListener> listeners = new HashSet<DiffListener>();
    
    public void addDiffListener(DiffListener listener) {
        listeners.add(listener);
    }
    
    public void removeDiffListener(DiffListener listener) {
        listeners.remove(listener);
    }


    protected void fireAddMatchingEntities(Map<OWLEntity, OWLEntity> newMatches) {
        for (DiffListener listener : listeners) {
            listener.addMatchingEntities(newMatches);
        }
    }

    protected void fireAddMatchingAnonymousIndividuals(Map<OWLAnonymousIndividual, OWLAnonymousIndividual> newMatches){
        for (DiffListener listener : listeners) {
            listener.addMatchingAnonymousIndividuals(newMatches);
        }
    }
    protected void fireAddMatch(OWLEntity source, OWLEntity target){
        for (DiffListener listener : listeners) {
            listener.addMatch(source, target);
        }
    }
    protected void fireAddMatch(OWLAnonymousIndividual source, OWLAnonymousIndividual target){
        for (DiffListener listener : listeners) {
            listener.addMatch(source, target);
        }
    }
    
    protected void fireAddUnmatcheableAxiom(OWLAxiom axiom) {
        for (DiffListener listener : listeners) {
            listener.addUnmatcheableAxiom(axiom);
        }
    }

    protected void fireAddMatchedAxiom(OWLAxiom axiom) {
        for (DiffListener listener : listeners) {
            listener.addMatchedAxiom(axiom);
        }
    }


}
