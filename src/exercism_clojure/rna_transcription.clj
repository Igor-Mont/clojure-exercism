(ns exercism-clojure.rna_transcription (:require [clojure.string :as str]))

(defn get-complement [nucleotide]
  (case nucleotide
    \G \C
    \C \G
    \T \A
    \A \U
    (throw (AssertionError. "Nucleotide invalid"))
    )
  )

(defn to-rna [dna]
  (if (empty? dna)
    ""
    (apply str (get-complement (first dna)) (to-rna (rest dna)))))


(println (to-rna "XCGFGGTDTTAA"))