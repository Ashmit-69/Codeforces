<h2><a href="https://codeforces.com/contest/1167/problem/B" target="_blank" rel="noopener noreferrer">1167B — Lost Numbers</a></h2>

| | |
|---|---|
| **Difficulty** | 1400 |
| **Language** | Java 21 |
| **Verdict** | ✅ Accepted |
| **Problem Link** | [Codeforces 1167B](https://codeforces.com/contest/1167/problem/B) |

## Topics
`brute force` `divide and conquer` `interactive` `math`

---

## Problem Statement

<div class="header"><div class="title">B. Lost Numbers</div><div class="time-limit"><div class="property-title">time limit per test</div>1 second</div><div class="memory-limit"><div class="property-title">memory limit per test</div>256 megabytes</div><div class="input-file input-standard"><div class="property-title">input</div>standard input</div><div class="output-file output-standard"><div class="property-title">output</div>standard output</div></div><div><p><span class="tex-font-style-bf">This is an interactive problem. Remember to flush your output while communicating with the testing program.</span> You may use <span class="tex-font-style-tt">fflush(stdout)</span> in C++, <span class="tex-font-style-tt">system.out.flush()</span> in Java, <span class="tex-font-style-tt">stdout.flush()</span> in Python or <span class="tex-font-style-tt">flush(output)</span> in Pascal to flush the output. If you use some other programming language, consult its documentation. You may also refer to the guide on interactive problems: <a href="https://codeforces.com/blog/entry/45307">https://codeforces.com/blog/entry/45307</a>.</p><p>The jury guessed some array $$$a$$$ consisting of $$$6$$$ integers. There are $$$6$$$ special numbers — $$$4$$$, $$$8$$$, $$$15$$$, $$$16$$$, $$$23$$$, $$$42$$$ — and each of these numbers occurs in $$$a$$$ exactly once (so, $$$a$$$ is some permutation of these numbers).</p><p>You don't know anything about their order, but you are allowed to ask <span class="tex-font-style-bf">up to $$$4$$$ queries</span>. In each query, you may choose two indices $$$i$$$ and $$$j$$$ ($$$1 \le i, j \le 6$$$, $$$i$$$ and $$$j$$$ are not necessarily distinct), and you will get the value of $$$a_i \cdot a_j$$$ in return.</p><p>Can you guess the array $$$a$$$?</p><p><span class="tex-font-style-bf">The array $$$a$$$ is fixed beforehand in each test, the interaction program doesn't try to adapt to your queries</span>.</p></div><div><div class="section-title">Interaction</div><p>Before submitting the answer, you may ask up to $$$4$$$ queries. To ask a query, print one line in the following format: $$$?$$$ $$$i$$$ $$$j$$$, where $$$i$$$ and $$$j$$$ should be two integers such that $$$1 \le i, j \le 6$$$. <span class="tex-font-style-it">The line should be ended with a line break character</span>. After submitting a query, flush the output and read the answer to your query — one line containing one integer $$$a_i \cdot a_j$$$. If you submit an incorrect query (or ask more than $$$4$$$ queries), the answer to it will be one string <span class="tex-font-style-tt">0</span>. After receiving such an answer, your program should terminate immediately — otherwise you may receive verdict "Runtime error", "Time limit exceeded" or some other verdict instead of "Wrong answer".</p><p>To give the answer, your program should print one line $$$!$$$ $$$a_1$$$ $$$a_2$$$ $$$a_3$$$ $$$a_4$$$ $$$a_5$$$ $$$a_6$$$ <span class="tex-font-style-it">with a line break in the end</span>. After that, it should flush the output and terminate gracefully.</p></div><div class="sample-tests"><div class="section-title">Example</div><div class="sample-test"><div class="input"><div class="title">Input<div title="Copy" data-clipboard-target="#id004420818508642431" id="id0019500115119270034" class="input-output-copier">Copy</div></div><pre id="id004420818508642431">16
64
345
672</pre></div><div class="output"><div class="title">Output<div title="Copy" data-clipboard-target="#id005426941957386654" id="id003185293851932355" class="input-output-copier">Copy</div></div><pre id="id005426941957386654">? 1 1
? 2 2
? 3 5
? 4 6
! 4 8 15 16 23 42</pre></div></div></div><div class="note"><div class="section-title">Note</div><p>If you want to submit a hack for this problem, your test should contain exactly six space-separated integers $$$a_1$$$, $$$a_2$$$, ..., $$$a_6$$$. Each of $$$6$$$ special numbers should occur exactly once in the test. The test should be ended with a line break character.</p></div>