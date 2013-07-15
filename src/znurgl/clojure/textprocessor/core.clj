(ns znurgl.clojure.textprocessor.core)

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
  (clojure.string/split 
    (read-file filename) #"[\:|\.][ |\n]"
    )
  )

; START: main
(defn -main [& args]
  ; creating a normalized list of input text file
  ;(norm-file "resources/test1.txt")  
  ;
  ; counting sentences of input text file
  ; (count-sentences "resources/test1.txt")
  (println "Count of sentences: "
    (count (count-sentences "resources/test1.txt"))
    )  
  )
; END: main