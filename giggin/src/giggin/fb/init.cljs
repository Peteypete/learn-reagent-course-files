(ns giggin.fb.init
  (:require ["firebase/app" :as firebase]
            ["firebase/database"]
            ["firebase/auth"]))

(defn firebase-init
  []
  (firebase/initializeApp
   {:apiKey "AIzaSyA3Paue5zGJNavKGcG7TXJnNs1KhYdDlRs"
    :authDomain "giggin-4d4d7.firebaseapp.com"
    :databaseURL "https://giggin-4d4d7.firebaseio.com"
    :projectId "giggin-4d4d7"}))
