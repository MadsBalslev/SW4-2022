# Formal semantic specification
## Abstract syntax
### Syntactic categories
### Formation rules
$$
\begin{align}

r ::= & \; \text{main recipe } ri \text{ \{ ingredients \{ }  \; id \text{ \} } \text{ , tools \{ } td \text{ \} , steps \{ } sd \text{ \} \} }   \\ 
\mid & \; \text{recipe } ri \text{ \{ ingredients \{ }  \; id \text{ \} } \text{ , tools \{ } td \text{ \} , steps \{ } sd \text{ \} \} }   \\ 
\mid & \; r_1 \text{ , } r_2 \\
\mid & \; \epsilon \\

id ::= & \; iti \; ii \; ad \\
\mid & \; iti \; ii \; ad \text{ or } id_1 \\
\mid & \; \text{recipe} \; ri \; \\
\mid & \; iti_1 \; iti_2 \\
\mid & \; id_1 \text{ , } id_2 \\

td ::= & \; tti \; ti \; tad \\
\mid & \; td_1 \text{ , } td_2 \\


\end{align}
$$
