(ns exercism-clojure.pig_latin
  (:require [clojure.string :as str]))

(defn consonant?
  [char]
  (let [consonants "bcdfghjklmnpqrstvwxyz"]
    (str/includes? consonants (str char))))

(defn letters-until-qu
  [s]
  (if (str/includes? s "qu")
    (let [index-of-qu (str/index-of s "qu")
          pre-qu (apply str (take index-of-qu s))
          all-consonants (every? consonant? pre-qu)
          ]
      (println index-of-qu)
      (println pre-qu)
      {:all-consonants all-consonants
       :substring      (if all-consonants pre-qu "")
       })
    {:all-consonants false
     :substring ""}))

(println "teste" (:substring (letters-until-qu "square")))

(defn letters-until-y
  [s]
  (if (str/includes? s "y")
    (let [index-of-y (str/index-of s "y")
          pre-y (apply str (take index-of-y s))
          all-consonants (every? consonant? pre-y)
          ]
      (println "all-consonants" all-consonants)
      (println pre-y)
      {:all-consonants (if (empty? pre-y) false all-consonants)
       :substring     (if all-consonants pre-y "")
       })
    {:all-consonants false
     :substring ""}))

(println "TESTE all-consonants" (letters-until-y "yellow"))

(defn take-while-consonant
  [s]
  (str/join (take-while #(consonant? %) s)))

(println (take-while-consonant "chair"))

(defn starts-with-consonant?
  [s]
    (consonant? (first s)))

(println (starts-with-consonant? "ig"))

(defn starts-with-vowel?
  [s]
  (let [vowels "aeiou"]
    (str/includes? vowels (str (first s)))))

(defn starts-with-xr-or-yt?
  [s]
  (or (str/starts-with? s "xr") (str/starts-with? s "yt")))

(defn add-ay-in-final
  [s]
  (str s "ay"))

(println (add-ay-in-final "pig"))

(println (starts-with-vowel? "apple"))
(println (starts-with-xr-or-yt? "xray"))
(println (starts-with-xr-or-yt? "yttria"))

(defn enter-rule-1?
  [s]
  (or (starts-with-vowel? s) (starts-with-xr-or-yt? s)))

(defn enter-rule-2?
  [s]
  (starts-with-consonant? s))

(defn enter-rule-3?
  [s]
  (:all-consonants (letters-until-qu s)))

(defn enter-rule-4?
  [s]
  (:all-consonants (letters-until-y s)))


(defn handle-translate
  [s]
  (let [substring-until-qu (:substring (letters-until-qu s))
        substring-until-y (:substring (letters-until-y s))
        substring-while-consonant (take-while-consonant s)]
    (cond
      (enter-rule-1? s) (add-ay-in-final s)
      (enter-rule-3? s) (add-ay-in-final
                          (str
                            (subs s (+ 2 (count substring-until-qu)))
                            (str substring-until-qu)
                            "qu"))
      (enter-rule-4? s) (add-ay-in-final
                          (str
                            (subs s (count substring-until-y))
                            substring-until-y))
      (enter-rule-2? s) (add-ay-in-final (str
                                           (subs s (count substring-while-consonant))
                                           substring-while-consonant))
      :else s))
  )

(defn translate
  [s]
  (str/join " " (map handle-translate (str/split s #" ")))
  )

(println (translate "#ffff0000"))