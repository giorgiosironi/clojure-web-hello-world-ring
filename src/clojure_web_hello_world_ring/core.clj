(ns clojure-web-hello-world-ring.core
    (:use ring.adapter.jetty)
    (:use clojure.string))
(defn extract-name [uri]
    (replace-first uri "/" ""))
(defn app [req]
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body    (if (= (:uri req) "/") 
                  "Hello, World!"
                  (str "Hello, " (extract-name (:uri req)) "!"))})
(defn -main [] (run-jetty #'app {:port 8080}))
