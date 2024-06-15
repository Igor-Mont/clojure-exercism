(ns exercism-clojure.anagram)

(defn assoc-map-count-char
  [mapa c]
  (let [c-lowercase (Character/toLowerCase c)]
    (assoc mapa c-lowercase (inc (get mapa c-lowercase 0)))))

(defn char-count-map
  [word]
  (reduce assoc-map-count-char {} word))

(defn str-to-lowercase
  [s]
  (apply str (map #(Character/toLowerCase %) s)))

(defn anagrams-for
  [word prospect-list]
  (let [map-word (char-count-map word)]
    (filter #(= (char-count-map %) map-word)
            (filter #(not= (str-to-lowercase %) (str-to-lowercase word)) prospect-list))
    )
  )
;
(println (anagrams-for "stone" ["stone", "tones", "banana", "tons", "notes", "Seton"]))
;(println (anagrams-for "BANANA" ["Banana"]))
;
;(println (anagrams-for "BANANA" ["Banana"]))
;(println (map str (anagrams-for "ΑΒΓ" ["ΒΓΑ" "ΒΓΔ" "γβα" "αβγ"])))