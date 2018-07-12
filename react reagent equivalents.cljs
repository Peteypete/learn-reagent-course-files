
;;Lecture 2
;;JavaScript
function app ()
  {
    return(<div id="id" class="class"></div>)
  }
;;ClojureScript
(defn app
  []
  [:div#id.class])


;;JavaScript Variants
function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}
class Welcome extends React.Component {
  render() {
    return <h1>Hello, {this.props.name}</h1>;
  }
}
(defn welcome[]
  [:welcome "Hello,"])

;; Lecture 3
(assoc gigs :one 1)

(def gigs-atom (atom {}))

(swap! gigs-atom assoc :one 1)

@gigs-atom

;;Lecture 5
(map (fn [number]
                [:div number])
                [1 2 3])


(map (fn [gig]
               [:div.gig
                 [:img.gig__artwork {:src (get gig :img) :alt (:title gig)}]
                 [:div.gig__body
                  [:div.gig__title
                   [:div.btn.btn--primary.float--right.tooltip {:data-tooltip "Add to order"}
                    [:i.icon.icon--plus]] (:title gig)]
                     [:p.gig__price "price"]
                     [:p.gig_desc "desc"]]]) (vals @state/gigs))

vals

;;Lecture 6
List comprehension
(for [gig (vals @state/gigs)])

destructure the gig

(get gig :title)
(:title gig)

{:keys [id img title price desc]}
title

;;Lecture 7

:on-click (fn [] (swap! state/orders update id inc))
;;Connect Repl to app
  (shadow.cljs.devtools.api/nrepl-select :app)

;;evaluate a namespace
opt+cmd+B

;;Lecture 8
<aside>

(for [[id quant] @state/orders]
  [:div.item {:key id}
   [:div.img
    [:img {:src (get-in @state/gigs [id :img])
           :alt (get-in @state/gigs [id :title])}]]
    [:div.content
     [:p.title (str (get-in @state/gigs [id :title]) " \u00D7 " quant)]]
    [:div.action
     [:div.price (* (get-in @state/gigs [id :price]) quant)]]])
;;Lecture 9
disassoc

[:div.btn.btn--primary.float--right.tooltip
 {:data-tooltip "Add to order"
 :on-click (fn [] (swap! state/orders update id inc))}
 [:i.icon.icon--plus]]


  [:button.btn.btn--link.tooltip
    {:data-tooltip "Remove"
     :on-click (fn [] (swap! state/orders dissoc id))}
    [:i.icon.icon--cross]]

;;Lecture 10

 [:button.btn.btn--link.tooltip
  {:data-tooltip "Remove all"
   :onclick (fn [] (reset! state/orders {}))}
  [:i.icon.icon--delete]]

 (reduce + (map (fn [[id quant]] (* quant (get-in @state/gigs [id :price]))) @state/orders)))

;;thread last macro
(->> @state/orders
     (map (fn [[id quant]] (* quant (get-in @state/gigs [id :price]))))
     (reduce +))

;;Lecture 11
;;predicate function - function that returns a true or false - anything with a ? at the end
  (if (empty? @state/orders)
    [true]
    [false])

;; Lecture 12


(defn greet-1 [name last] (str "Hello " name last))
(def greet-2 (fn [name last] (str "Hello " name last)))
(def greet-3 #(str "Hello " %1 %2))

(greet-1 "peter" "wen")
(greet-2 "peter" "wen")
(greet-3 "peterrrr" "wen")

;;let binding

;Lecture 13
; component level state

;Wrap mark-up do not include component level state in the render function
