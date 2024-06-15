(ns exercism-clojure.nucleotide_count)

(defn is-nucleotide? [nucleotide]
  (some #(= nucleotide %) "ATCG"))

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (is-nucleotide? nucleotide)
    (count (filter #(= % nucleotide) strand))
    (throw (Exception. "invalid nucleotide"))))

(defn form-map-nucleotides-counts
  [map nucleotide strand]
  (assoc map nucleotide (count-of-nucleotide-in-strand nucleotide strand)))


(defn nucleotide-counts [strand]
  (let [initial-map {\A 0 \C 0 \G 0 \T 0}
        map-nucleotides (reduce #(form-map-nucleotides-counts %1 %2 strand) initial-map strand)]
      (if (empty? strand) initial-map (into (sorted-map) (sort-by key map-nucleotides))))
  )
(println (nucleotide-counts "X"))
