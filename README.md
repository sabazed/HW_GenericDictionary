# Generic Dictionary
<p>In this project you have to create Map-like data structure - Dictionary.
In general it is a good practice to provide several implementations of such
data structures as different problems have different requirements. For example,
in Java API ArrayList and LinkedList implement same interface, but they use
different approaches to solve same problems. Therefore we are going to provide
2 different implementations of Dictionary as well: ListDictionary and SetDictionary.
You have to implement these classes and some additional helper classes.</p>
<h4 id="option">Option</h4>
<p>Implement a generic class <code>Option</code>. It may or may
not contain a non-null value. Implement following
methods:</p>
<ul>
<li>2 constructors. One with a value as an parameter
and another with no parameter at all. To restrict
storing <code>null</code> as a value, these constructors
MUST be <code>private</code>. The first constructor should store
the given value as a class attribute. The second constructor
should not store anything and mark object as empty.</li>
<li>As constructors are <code>private</code> we need static methods
to create objects of class <code>Option</code>. Implement static
generic method <code>some</code> that takes a value as an parameter
and creates an <code>Option</code> object storing it.</li>
<li>Implement static generic method <code>none</code> that does not
take any parameters and creates an <code>Option</code> object
without any value stored (empty option).</li>
<li><code>get</code> method should return the stored value. If it
does not contain any value then throw <code>EmptyOptionException</code>.</li>
<li><code>getOrDefault</code> method should return the stored value. If it
does not contain any value, then return default value given as the parameter.</li>
<li><code>isNone</code> should return <code>true</code> if object does not contain
value, otherwise it should return <code>false</code>.</li>
</ul>
<h4 id="dictionary">Dictionary</h4>
<p>You should write 2 implementations
of <code>Dictionary</code> interface. <code>Dictionary</code> interface
is already given. It has 2 generic type parameters: <code>K</code> - 
key type, <code>V</code> - value type. Dictionary objects should
store a mapping of <code>K</code> type keys to <code>V</code> type values.</p>
<p>Interface has following methods:</p>
<ul>
<li><code>get(K key)</code> takes a key as a parameter and should
find value mapped to this key. If such a key exists
in the dictionary, the method should return <code>Option</code> 
object with value stored in it. If such key does
not exist in the map, it should return empty <code>Option</code>
object.</li>
<li><code>get(K key, V defaultValue)</code> takes a key as a 1st parameter and should
find value mapped to this key. If such key exists
in the dictionary, the method should return the value associated
with it. If there is no such key, return <code>defaultValue</code>
given as a 2nd parameter.</li>
<li><code>containsKey</code> should check if the given key exists in
dictionary and return true if it exists and return false otherwise.</li>
<li><code>put</code> takes 2 parameters: key and value. Method should check if
such key already exists in dictionary. If it does return false,
otherwise store this new key-value mapping and return true.</li>
<li><code>update</code> takes 2 parameters: key and value. Method should check if
such key already exists in dictionary. If it does NOT exist, return false.
Otherwise, find value associated with the given key and change
old one with the new value and return true.</li>
<li><code>clear</code> gets key as a patameter. Find if this key exists
in the dictionary and if it does remove both key and value
associated with it.</li>
<li><code>keyStream</code> should return stream that contains all keys from
the dictionary.</li>
<li><code>valueStream</code> should return stream that contains all values from
the dictionary. Note: duplicate values are allowed.</li>
</ul>
<h5 id="listdictionary">List Dictionary</h5>
<p>Implement <code>ListDictionary</code> class. This class should
implement <code>Dictionary</code> interface (and therefore all it's methods).
<code>ListDictionary</code> should have 2 attributes: <code>List&lt;K&gt; keys</code> and <code>List&lt;V&gt; values</code>.
You should use these 2 lists to store key-value mappings: i-th element
in <code>values</code> list should be a value associated with the key on i-th index
from <code>keys</code> list.</p>
<p>For example, if lists are following: <br>
<code>values</code> := ["A", "B", "C"] <br>
<code>keys</code> := [17, 1, 9] <br>
It means that we have following key-value pairs: 17-"A", 1-"B", 9-"C".</p>
<p>You should implement all methods from <code>Dictionary</code>
interface using these 2 lists. <strong>You are NOT allowed to
add any other attributes to the <code>ListDictionary</code> class.</strong>
Adding other attributes will result in getting 0 points.</p>
<h5 id="setdictionary">Set Dictionary</h5>
<p>Implement <code>SetDictionary</code> class. This class should
implement the <code>Dictionary</code> interface.
<code>SetDictionary</code> should have only 1 attribute: <code>Set&lt;Pair&lt;K, V&gt;&gt; entries</code>.
You should use this set to store key-value mappings: each pair from the list
represents one key-value mapping, the first element from the pair is a key and the second
one is a value. <code>Pair&lt;T1,T2&gt;</code> class is already given.</p>
<p>For example, if set is following: <br>
<code>entries</code> := [<code>new Pair(17,"A")</code>, <code>new Pair(1,"B")</code>, <code>new Pair(9, "C")</code>] <br>
It means that we have following key-value pairs: 17-"A", 1-"B", 9-"C".</p>
<p>You should implement all methods from <code>Dictionary</code>
interface using this one set. <strong>You are NOT allowed to
add any other attributes to the <code>SetDictionary</code> class.</strong>
Adding other attributes will result in getting 0 points.</p>
<p>NOTE: Submitted code should not have any compilation errors!
<strong>If your code can not be compiled and run you will get 0 points
automatically.</strong></p></div>
</div><!---->
<!---->
</jhi-programming-exercise-instructions><!---->
