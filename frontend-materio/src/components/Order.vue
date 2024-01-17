<template>
    <div>
        <String label="주문 ID" v-model="value.orderId" :editMode="editMode"/>
        <String label="음식 선택" v-model="value.foodSelection" :editMode="editMode"/>
        <Number label="수량" v-model="value.quantity" :editMode="editMode"/>
        <String label="특별 요청" v-model="value.specialRequest" :editMode="editMode"/>
        <String label="결제 방법" v-model="value.paymentMethod" :editMode="editMode"/>
        <String label="주문 상태" v-model="value.orderStatus" :editMode="editMode"/>
        <String label="예상 배달 시간" v-model="value.estimatedDeliveryTime" :editMode="editMode"/>
        <paymentMethodType offline label="결제 방법 유형" v-model="value.paymentMethodType" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity.vue'
import String from './primitives/String.vue'
import Number from './primitives/Number.vue'
import Address from './vo/Address.vue'
import paymentMethodType from './paymentMethodType.vue'
import Money from './vo/Money.vue'

export default {
    name: 'Order',
    mixins:[BaseEntity],
    components:{
        String,
        Number,
        Address,
        paymentMethodType,
        Money,
    },
    
    data: () => ({
        path: "orders"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
