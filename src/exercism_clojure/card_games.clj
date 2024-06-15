(ns exercism-clojure.cardGames)

(defn rounds
  "Takes the current round number and returns
   a `list` with that round and the _next two_."
  [n]
  (let  [inc-two (comp inc inc)]
    (list n (inc n) (inc-two n)))
  )

(println (rounds 27))

(defn concat-rounds
  "Takes two lists and returns a single `list`
   consisting of all the rounds in the first `list`,
   followed by all the rounds in the second `list`"
  [l1 l2]
  (concat l1 l2)
  )

(defn contains-round?
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (boolean (some #(= n %) l))
  )

(println (contains-round? '(1 2 3 4 5) 7))

(defn card-average
  "Returns the average value of a hand"
  [hand]
  (double (/ (reduce + hand) (count hand)))
  )

(println (card-average '(5 6 7)))

(defn approx-average?
  "Returns `true` if average is equal to either one of:
  - Take the average of the _first_ and _last_ number in the hand.
  - Using the median (middle card) of the hand."
  [hand]
  (let [first (first hand)
        last (last hand)
        length-hand (count hand)
        middle (nth hand (int (/ length-hand 2)))
        average (double (card-average hand))]
    (or (= average (card-average [first, last]))
        (= average (double middle)))
    )
  )

(println (approx-average? '(0 1 5)))

;[index-value-map (map vector (range) birds),
; even-vector (map second (filter #(even? (first %)) index-value-map)),

(defn average-even-odd?
  "Returns true if the average of the cards at even indexes
   is the same as the average of the cards at odd indexes."
  [hand]
  (let [odd-indexes (map second (filter #(odd? (first %)) (map vector (range) hand)))
        even-indexes (map second (filter #(even? (first %)) (map vector (range) hand)))]
    (= (card-average odd-indexes) (card-average even-indexes))
    )
  )

(println (average-even-odd? '(1 2 3)))
(println (average-even-odd? '(1 2 3 4)))

(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (let [last-item (last hand)]
    (if (= 11 last-item) (concat (take (dec (count hand)) hand) (list (* 2 last-item))) hand))
  )

(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (let [last-item (last hand)]
    (if (= 11 last-item) (->> hand
                             (take (dec (count hand)))
                              ) hand))
  )

(println (maybe-double-last '(5 9 10)))