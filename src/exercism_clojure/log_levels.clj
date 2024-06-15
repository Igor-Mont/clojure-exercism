(ns exercism-clojure.logLevels (:require [clojure.string :as str]))


(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (str/join " " (rest (str/split s #"\s+")))
  )

(println (message "[ERROR]: Invalid operation"))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (let [index-of-start-bracket (str/index-of s "[")
        index-of-end-bracket (str/index-of s "]")]
    (str/lower-case (subs s (inc index-of-start-bracket) index-of-end-bracket)))
  )

(println (log-level "[ERROR]: Invalid operation"))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str (message s) " (" (log-level s) ")" )
  )

(println (reformat "[INFO]: Operation completed"))