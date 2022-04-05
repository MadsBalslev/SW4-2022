# Formal semantic specification
## Abstract syntax
### Syntactic categories
$$
\begin{align}
    ri &\in RI - \text{Recipe identifier} \\
    ii &\in II - \text{Ingredient identifier} \\
    ti &\in TI - \text{Tool identifier} \\
    tai &\in TAI - \text{Tool action identifier} \\
    \\
    iti &\in ITI - \text{Ingredient type identifier} \\
    tti &\in TTI - \text{Tool type identifier} \\
    \\
    rd &\in RD - \text{Recipe declaration} \\
    id &\in ID - \text{Ingredient declaration} \\
    ad &\in AD - \text{Amount declaration} \\
    td &\in TD - \text{Tool declaration} \\
    tad &\in TAD - \text{Tool action declaration} \\
    sd &\in SD - \text{step declaration} \\
    \\
    ds &\in DS - \text{Description string} \\
    in &\in IN - \text{Step input} \\
    out &\in OUT - \text{Step output} \\
    ic &\in IC - \text{Ingredient collection} \\
\end{align}
$$

### Formation rules
$$
\begin{align}

rd ::= & \; \text{main recipe } ri \text{ \{ ingredients \{ }  \; id \text{ \} } \text{ , tools \{ } td \text{ \} , steps \{ } sd \text{ \} \} }   \\ 
\mid & \; \text{recipe } ri \text{ \{ ingredients \{ }  \; id \text{ \} } \text{ , tools \{ } td \text{ \} , steps \{ } sd \text{ \} \} }   \\ 
\mid & \; rd_1 \text{ , } rd_2 \\

id ::= & \; iti \; ii \; ad \\
\mid & \; id_1 \text{ or } id_2 \\
\mid & \; \text{recipe} \; ii \; \\
\mid & \; iti_p \; iti_c \\
\mid & \; id_1 \text{ , } id_2 \\

td ::= & \; tti \; ti \text{ [ } tad \text{ ] } \\
\mid & \; td_1 \text{ , } td_2 \\

tad ::= & \; tai \text{ : } iti_i \text{ => } iti_o \\
\mid & \text{ contain : } iti \\
\mid & \; tai \text{ : content in } ti \text{ => } iti \\
\mid & \; tad_1 \text{ , } tad_2 \\

sd ::= & \; ti \; \text{ do } tai \; ds \; in \\
\mid & \; ti \; \text{ do } tai \; ds \; in \text{ => } out \\
\mid & \; sd_1 \text{ , } sd_2 \\

in ::= & \; ii \mid \text{\{ } ic_1, ic_2, \dots, ic_n \text{ \}} \mid \text{content in} \; ti \\

out ::= & \; ii \mid \text{\{ } ic_1, ic_2, \dots, ic_n \text{ \}} \\


\end{align}
$$

## Additional sets and auxiliary functions

## Transition system
### Ingredient declaration transition system

$$
\begin{gather}
\frac{}{
    \langle iti \; ii \; ad, env_I, env_{IT}\rangle \rightarrow_{id} \langle env_I[ii \mapsto iti_c], env_{IT}\rangle
} \\
\text{if} \; env_{IT}(iti)\downarrow \\
\text{and} \; env_I(ii)\uparrow
\end{gather}
$$

$$
\begin{gather}
\frac{}{
    \langle iti_p \; iti_c, env_I, env_{IT}, env_R \rangle \rightarrow_{id} \langle env_I, env_{IT}[iti_c \mapsto iti_p], env_R \rangle
} \\
\text{if} \; env_{IT}(iti_p)\downarrow \\
\text{and} \; env_{IT}(iti_c)\uparrow \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    \langle id_1, env_I, env_{IT} \rangle \rightarrow_{id} \langle env_I'',env_{IT}'' \rangle \;
    \langle id_2, env_I'', env_{IT}'' \rangle \rightarrow_{id} \langle env_I',env_{IT}' \rangle \;
}{
    \langle id_1\text{ , } id_2, env_I, env_{IT} \rangle \rightarrow_{id} \langle env_I', env_{IT}'\rangle
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    \langle id_1, env_I, env_{IT} \rangle \rightarrow_{id} \langle env_I',env_{IT}' \rangle \;
}{
    \langle id_1\text{ or } id_2, env_I, env_{IT} \rangle \rightarrow_{id} \langle env_I', env_{IT}'\rangle
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    \langle id_2, env_I, env_{IT} \rangle \rightarrow_{id} \langle env_I',env_{IT}' \rangle \;
}{
    \langle id_1\text{ or } id_2, env_I, env_{IT} \rangle \rightarrow_{id} \langle env_I', env_{IT}'\rangle
} \\
\end{gather}
$$

### Tool action declaration transition system

$$
\begin{gather}
\frac{}{
    env_{IT}, env_{T} \vdash \langle tai \text{ : } iti_i \text{ => } iti_o, env_A \rangle \rightarrow_{tad} 
    env_A[tai \mapsto (iti_i, iti_o, \epsilon)]
} \\
\text{if} \; env_A(tai) \uparrow \\
\text{and} \; env_{IT}(iti_i) \downarrow \\
\text{and} \; env_{IT}(iti_o) \downarrow \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_{T} \vdash \langle tad_1, env_A \rangle \rightarrow_{tad} 
    env_A''
    \;
    env_{IT}, env_{T} \vdash \langle tad_2, env_A'' \rangle \rightarrow_{tad} 
    env_A'

}{
    env_{IT}, env_{T} \vdash \langle tad_1 \text{ , } tad_2, env_A \rangle \rightarrow_{tad} 
    env_A'
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{}{
    env_{IT}, env_{T} \vdash \langle \text{contain :} \; iti, env_A \rangle \rightarrow_{tad} 
    env_A[contain \mapsto (iti, iti,\epsilon)]
} \\
\text{if} \; env_A(contain) \uparrow \\
\text{and} \; env_{IT}(iti) \downarrow \\
\end{gather}
$$

$$
\begin{gather}
\frac{}{
    env_{IT}, env_{T} \vdash \langle tai \; \text{:} \; \text{content in} \; ti \text{=>} \; iti_o, env_A \rangle \rightarrow_{tad} 
    env_A[tai \mapsto (iti_i, iti_o,ti)]
} \\
\text{if} \; env_A(tai) \uparrow \\
\text{and} \; env_{IT}(iti_o) \downarrow \\
\text{and} \; env_{T}(ti) \downarrow \\
\text{where} \; env_T(ti) = env_{A}' \\
\text{and} \; env_{A}'(contain) = (iti_i, iti_i,\epsilon) \\
\end{gather}
$$

### Step declaration transition system

$$
\begin{gather}
\frac{}{
    env_{ITI} \vdash \langle ti \text{ do } tai \; ii, env_I, env_T, env_P \rangle \rightarrow 
    \langle env_I[ii \mapsto iti_o], env_T, env_P \rangle
} \\
\text{if } iti_i \in env_{ITI}^*(iti) \\
\text{where } env_T(ti) = (ti_p,env_A) \\
\text{and } env_A(tai) = (iti_i, iti_o) \\
\text{and } env_I(ii) = iti \\
\end{gather}
$$

$$
\begin{gather}
\frac{}{
    env_{ITI} \vdash \langle ti \text{ do } tai \; ii_i \text{ => } ii_o, env_I, env_T, env_P \rangle \rightarrow 
    \langle env_I[ii_i \mapsto \epsilon, ii_o \mapsto iti_o], env_T, env_P \rangle
} \\
\text{if } iti_i \in env_{ITI}^*(iti) \\
\text{and } env_{I}(ii_o) \uparrow \\
\text{where } env_T(ti) = (ti_p,env_A) \\
\text{and } env_A(tai) = (iti_i, iti_o) \\
\text{and } env_I(ii) = iti \\
\end{gather}
$$

$$
\begin{gather}
\frac{}{
    env_{ITI} \vdash \langle ti \text{ do } tai \; \text{ \{ } ii_1, ii_2, \dots, ii_n \text{ \} }, env_I, env_T, env_P \rangle \rightarrow
    \langle env_I[ii_1 \mapsto iti_o, ii_2 \mapsto iti_o, \dots, ii_n \mapsto iti_o], env_T, env_P \rangle
} \\
\text{if } iti_i \in env_{ITI}^*(iti_1) \\
\text{and } iti_i \in env_{ITI}^*(iti_2) \\
\vdots \\
\text{and } iti_i \in env_{ITI}^*(iti_n) \\
\text{where } env_T(ti) = (ti_p,env_A) \\
\text{and } env_A(tai) = (iti_i, iti_o) \\
\text{and } env_I(ii_1) = iti_1 \\
\text{and } env_I(ii_2) = iti_2 \\
\vdots \\
\text{and } env_I(ii_n) = iti_n \\

\end{gather}
$$

$$
\begin{gather}
\frac{}{
    env_{ITI} \vdash \langle ti \text{ do } tai \; \text{ \{ } ii_1, ii_2, \dots, ii_n \text{ \} => } ii, env_I, env_T, env_P \rangle \rightarrow
    \langle env_I[ii_1 \mapsto \epsilon, ii_2 \mapsto \epsilon, \dots, ii_n \mapsto \epsilon, ii \mapsto iti_o], env_T, env_P \rangle
} \\
\text{if } iti_i \in env_{ITI}^*(iti_1) \\
\text{and } iti_i \in env_{ITI}^*(iti_2) \\
\vdots \\
\text{and } iti_i \in env_{ITI}^*(iti_n) \\
\text{and } env_I(ii)\uparrow \\
\text{where } env_T(ti) = (ti_p,env_A) \\
\text{and } env_A(tai) = (iti_i, iti_o) \\
\text{and } env_I(ii_1) = iti_1 \\
\text{and } env_I(ii_2) = iti_2 \\
\vdots \\
\text{and } env_I(ii_n) = iti_n \\
\end{gather}
$$

$$
\begin{gather}
\frac{}{
    env_{ITI} \vdash \langle ti \text{ do } tai \; ii \text{ => } \text{ \{ } ii_1, ii_2, \dots, ii_n \text{ \} }, env_I, env_T, env_P \rangle \rightarrow
    \langle env_I[ii_1 \mapsto iti_o, ii_2 \mapsto iti_o, \dots, ii_n \mapsto iti_o, ii \mapsto \epsilon], env_T, env_P \rangle
} \\
\text{if } iti_i \in env_{ITI}^*(iti) \\
\text{and } env_I(ii_1)\uparrow \\
\text{and } env_I(ii_2)\uparrow \\
\vdots \\
\text{and } env_I(ii_n)\uparrow \\
\text{where } env_T(ti) = (ti_p,env_A) \\
\text{and } env_A(tai) = (iti_i, iti_o) \\
\text{and } env_I(ii) = iti \\
\end{gather}
$$

$$
\begin{gather}
\frac{}{
    env_{ITI} \vdash \langle ti \text{ do } tai \; \text{ \{ } ii_{i_1}, ii_{i_2}, \dots, ii_{i_n} \text{ \} } \text{ => } \text{ \{ } ii_{o_1}, ii_{o_2}, \dots, ii_{o_n} \text{ \} }, env_I, env_T, env_P \rangle \rightarrow
    \langle env_I[ii_{o_1} \mapsto iti_o, ii_{o_1} \mapsto iti_o, \dots, ii_{o_n} \mapsto iti_o, ii_{i_1} \mapsto \epsilon, ii_{i_1} \mapsto \epsilon, \dots, ii_{i_n} \mapsto \epsilon ], env_T, env_P \rangle
} \\
\text{if } iti_i \in env_{ITI}^*(iti_1) \\
\text{and } iti_i \in env_{ITI}^*(iti_2) \\
\vdots \\
\text{and } iti_i \in env_{ITI}^*(iti_n) \\
\text{and } env_I(ii_{o_1})\uparrow \\
\text{and } env_I(ii_{o_2})\uparrow \\
\vdots \\
\text{and } env_I(ii_{o_n})\uparrow \\
\text{where } env_T(ti) = (ti_p,env_A) \\
\text{and } env_A(tai) = (iti_i, iti_o) \\
\text{and } env_I(ii_{i_1}) = iti_1 \\
\text{and } env_I(ii_{i_2}) = iti_2 \\
\vdots \\
\text{and } env_I(ii_{i_n}) = iti_n \\
\end{gather}
$$

$$
\begin{gather}
\frac{}{
    env_{ITI} \vdash \langle ti \text{ do } tai \text{ content in } ti, env_I, env_T, env_P \rangle \rightarrow
    \langle env_I, env_T, env_P \rangle
} \\
\text{and } env_I(ii_{i_n}) = iti_n \\
\end{gather}
$$





