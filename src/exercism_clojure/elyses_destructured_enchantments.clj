(ns exercism-clojure.elysesDestructuredEnchantments)


(defn first-card
  "Returns the first card from deck."
  [[first-card-deck]]
  first-card-deck
  )

(println (first-card [5 9 7 1 8]))

(defn second-card
  "Returns the second card from deck."
  [[_ second-card-deck]]
  second-card-deck
  )

(println (second-card [5 9 7 1 8]))


(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (concat [(second-card deck) (first-card deck)] (drop 2 deck))
  ;(vec (second-card deck) (first-card deck) deck)
  )

(println (swap-top-two-cards [5 9 7 1 8]))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (cons (first-card deck) (conj [] (seq (drop 1 deck))))
  )

(println (discard-top-card [5]))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (let [first-card-deck (first-card deck)]
    (if first-card-deck
      (cons first-card-deck
            (concat face-cards (rest deck)))
      face-cards)
    )
  )

(println (insert-face-cards []))