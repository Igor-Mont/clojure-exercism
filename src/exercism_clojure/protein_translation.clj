(ns exercism-clojure.protein-translation
  (:require [clojure.string :as str]))

(defn translate-codon
  [codon]
  (case codon
    "AUG" "Methionine"
    ("UUU" "UUC") "Phenylalanine"
    ("UUA" "UUG") "Leucine"
    ("UCU" "UCC" "UCA" "UCG") "Serine"
    ("UAU" "UAC") "Tyrosine"
    ("UGU" "UGC") "Cysteine"
    "UGG" "Tryptophan"
    ("UAA" "UAG" "UGA") "STOP"
    "Unknown"))

(defn translate-rna
  [rna]
  (->> rna
       (partition 3)
       (map str/join)
       (map translate-codon)
       (take-while (partial not= "STOP"))))

(println (translate-rna "AUGUUUUGG"))