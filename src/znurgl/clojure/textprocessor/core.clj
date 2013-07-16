(ns znurgl.clojure.textprocessor.core)

; create determiner lists
(def quantifiers ["some" "any" "few" "little" "more" "much" 
                  "many" "each" "every" "both" "all" "enough" 
                  "half" "little" "whole" "less"])

; reading a file
(defn read-file [filename]
  (slurp filename)
  )

; removing irrelevant characters
(defn rm-irrelevant [str]
  (clojure.string/replace str #"\.|\,|\:|\n|\(|\)|\"|\\" "")    
  )

; creating a sorted list with distinct elements
(defn cr-list [str]
  (distinct
	  (sort
	    (clojure.string/split str #" ")
     )
   )
  )

; get a normalized list from file
(defn norm-file [filename]
  (cr-list
    (.toLowerCase
      (rm-irrelevant 
        (read-file filename)
        )
      )   
    ) 
  )

; Counting sentences. A sentence is ending with a dot and the next char would be 
; a space or a line break and the next char should be a Capital letter.
(defn count-sentences [filename]
  (count
    (clojure.string/split 
      (read-file filename) #"[\:|\.][ |\n]"
      )
    )
  )

; Find 'ing'-s
(defn find-ing [list]
  (re-seq #"\w+ing" list)
  )

; START: main
(defn -main [& args]
  
  ; example file for testing
  (def filename "resources/test1.txt")
  
  ; creating a normalized list of input text file
  (println "Normalized list: "
    (norm-file filename)
    )  
  ;
  ; counting sentences of input text file
  ; (count-sentences "resources/test1.txt")
  (println "Count of sentences: "
    (count-sentences filename)
    )  
  
  (println "Words with -ing ending: "
    (find-ing (read-file filename))
    )
  )
; END: main